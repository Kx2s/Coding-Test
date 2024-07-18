import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Customer[] customers = new Customer[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            customers[i] = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(customers);

        int ans = 0;
        int mx = 0;
        for (int i=0; i<N; i++) {
            int tmp = 0;
            int money = customers[i].price;
            for (Customer c : customers) {
                if (c.price >= money && c.cost < money) {
                    tmp += money - c.cost;
                }
            }
            if (mx < tmp) {
                mx = tmp;
                ans = money;
            }
        }
        System.out.println(ans);
    }

    static class Customer implements Comparable<Customer>{
        int price;
        int cost;

        public Customer(int price, int cost) {
            this.price = price;
            this.cost = cost;
        }

        @Override
        public int compareTo(Customer o) {
            return price-o.price;
        }
    }
}