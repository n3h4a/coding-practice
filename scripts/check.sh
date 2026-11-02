#!/usr/bin/env bash
# Compiles every solution and runs the unit tests in tests/.
#
# LeetCode solutions omit imports and rely on helper types (TreeNode,
# MountainArray, ...), so each file is compiled in its own sandbox with the
# usual imports prepended and the stubs from scripts/stubs on the path.
#
# Usage: scripts/check.sh

set -euo pipefail
shopt -s nullglob

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
STUBS="$ROOT/scripts/stubs"
WORK="$(mktemp -d)"
trap 'rm -rf "$WORK"' EXIT

PRELUDE='import java.util.*; import java.util.function.*; import java.util.stream.*;'

# Copies a solution into $1 under the file name javac expects.
stage_solution() {
    local dest="$1" src="$2" name
    name="$(grep -oE '^public (final )?class [A-Za-z0-9_]+' "$src" | awk '{print $NF}' || true)"
    { echo "$PRELUDE"; cat "$src"; } > "$dest/${name:-Solution}.java"
}

compiled=0
failed=0

echo "==> Compiling solutions"
for src in "$ROOT"/*/*.java; do
    case "$src" in "$ROOT"/tests/*|"$ROOT"/scripts/*) continue ;; esac
    dir="$WORK/compile/$(basename "$(dirname "$src")")"
    mkdir -p "$dir"
    stage_solution "$dir" "$src"
    cp "$STUBS"/*.java "$dir/"
    if javac -nowarn -d "$dir/out" "$dir"/*.java 2> "$dir/errors.txt"; then
        compiled=$((compiled + 1))
    else
        failed=$((failed + 1))
        echo "FAIL  ${src#"$ROOT"/}"
        cat "$dir/errors.txt"
    fi
done
echo "    $compiled compiled, $failed failed"

echo "==> Running tests"
passed=0
for test in "$ROOT"/tests/*/Tests.java; do
    problem="$(basename "$(dirname "$test")")"
    dir="$WORK/test/$problem"
    mkdir -p "$dir"
    stage_solution "$dir" "$(ls "$ROOT/$problem"/*.java)"
    cp "$STUBS"/*.java "$ROOT/tests/Assert.java" "$dir/"
    { echo "$PRELUDE"; cat "$test"; } > "$dir/Tests.java"
    if javac -nowarn -d "$dir/out" "$dir"/*.java && java -ea -cp "$dir/out" Tests; then
        passed=$((passed + 1))
        echo "PASS  $problem"
    else
        failed=$((failed + 1))
        echo "FAIL  $problem"
    fi
done
echo "    $passed test suites passed"

if [ "$failed" -ne 0 ]; then
    echo "$failed failure(s)"
    exit 1
fi
echo "All good."
