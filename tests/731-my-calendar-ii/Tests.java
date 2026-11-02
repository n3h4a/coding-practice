class Tests {
    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        Assert.isTrue(calendar.book(10, 20));
        Assert.isTrue(calendar.book(50, 60));
        Assert.isTrue(calendar.book(10, 40));
        Assert.isFalse(calendar.book(5, 15));
        Assert.isTrue(calendar.book(5, 10));
        Assert.isTrue(calendar.book(25, 55));
    }
}
