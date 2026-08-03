class MinStack {

    Stack<Long> st;
    Long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        if (st.isEmpty()) {
            st.push((long) value);
            min = (long) value;
        }
        else if (value >= min) {
            st.push((long) value);
        }
        else {
            st.push(2L * value - min);
            min = (long) value;
        }
    }

    public void pop() {

        if (st.isEmpty()) return;

        long temp = st.pop();

        if (temp < min) {
            min = 2 * min - temp;
        }

        if (st.isEmpty()) {
            min = null;
        }
    }

    public int top() {

        long temp = st.peek();

        if (temp >= min)
            return (int) temp;

        return min.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}