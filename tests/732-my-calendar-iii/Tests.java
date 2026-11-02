class Tests {
    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        Assert.equal(1, calendar.book(10, 20));
        Assert.equal(1, calendar.book(50, 60));
        Assert.equal(2, calendar.book(10, 40));
        Assert.equal(3, calendar.book(5, 15));
        Assert.equal(3, calendar.book(5, 10));
        Assert.equal(3, calendar.book(25, 55));
    }
}
