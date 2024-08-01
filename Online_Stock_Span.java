class StockSpanner {
    
    class Spanner{
        int val;
        int cost;
        Spanner(int val,int cost){
            this.val = val;
            this.cost = cost;
        }
    }
    
    Stack<Spanner> spannerStack;

    public StockSpanner() {
        spannerStack = new Stack<>();
    }
    
    public int next(int price) {
        int cost = 1;
        while(!spannerStack.isEmpty() && spannerStack.peek().val <= price){
            cost = cost + spannerStack.pop().cost;
        }
        spannerStack.add(new Spanner(price,cost));
        return cost;
    }
}