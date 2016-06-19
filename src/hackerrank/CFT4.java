/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author keyur
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class CFT4 {

    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int n = ni(), Q = ni();
        int[] par = new int[n];
        for (int i = 1; i < n; i++) {
            par[i] = ni() - 1;
        }

        par[0] = -1;

        int[][] g = parentToG(par);

        int[][] pars = parents3(g, 0);

        int[] dep = pars[2];
        EulerTour et = nodalEulerTour(g, 0);

        // F^-n=[[f(n-1), -f(n)],[-f(n), f(n+1)]]
        // F^n=[[f(n+1), f(n)],[f(n), f(n-1)]]
        int[] f = new int[100005];
        f[1] = f[2] = 1;
        int mod = 1000000007;
        for (int i = 3; i <= 100004; i++) {
            f[i] = f[i - 1] + f[i - 2];
            if (f[i] >= mod) {
                f[i] -= mod;
            }
        }

        long[] ft0 = new long[2 * n + 3];
        long[] ft1 = new long[2 * n + 3];
        Scanner scan = new Scanner(System.in);
        for (int k = 0; k < Q*3; k++) {
//            char t = nc();
            String t = scan.next();

            System.out.println("T::" + t+ "::"+t.equals("Q")+" ,::"+t.equals("U"));
            if (t.equals("Q")) {
                System.out.println("QQQ");
                int x = ni() - 1;
                long v0 = sumFenwick(ft0, et.first[x]);
                long v1 = sumFenwick(ft1, et.first[x]);
                out.println((f[dep[x] + 1 + 1] * v0 + f[dep[x] + 1] * v1) % mod);
            } else if (t.equals("U")) {
                System.out.println("UUU");
                int x = ni() - 1;
                int v = ni();

                long v0 = (long) f[v] * f[dep[x] - 1 + 1] + (long) f[v - 1] * -f[dep[x] + 1];
                long v1 = (long) f[v] * -f[dep[x] + 1] + (long) f[v - 1] * f[dep[x] + 1 + 1];
                if ((dep[x] + 1) % 2 != 0) {
                    v0 = -v0;
                    v1 = -v1;
                }
                addFenwick(ft0, et.first[x], v0);
                addFenwick(ft1, et.first[x], v1);
                addFenwick(ft0, et.last[x], -v0);
                addFenwick(ft1, et.last[x], -v1);
            }
            System.out.println("z::" + k);

        }
    }

    public static final int mod = 1000000007;

    public static long sumFenwick(long[] ft, int i) {
        long sum = 0;
        for (i++; i > 0; i -= i & -i) {
            sum += ft[i];
            if (sum >= mod) {
                sum -= mod;
            }
        }
        return sum;
    }

    public static void addFenwick(long[] ft, int i, long v) {
        v %= mod;
        if (v < 0) {
            v += mod;
        }
        if (v == 0) {
            return;
        }
        int n = ft.length;
        for (i++; i < n; i += i & -i) {
            ft[i] += v;
            if (ft[i] >= mod) {
                ft[i] -= mod;
            }
        }
    }

    public static int[][] parents3(int[][] g, int root) {
        int n = g.length;
        int[] par = new int[n];
        Arrays.fill(par, -1);

        int[] depth = new int[n];
        depth[0] = 0;

        int[] q = new int[n];
        q[0] = root;
        for (int p = 0, r = 1; p < r; p++) {
            int cur = q[p];
            for (int nex : g[cur]) {
                if (par[cur] != nex) {
                    q[r++] = nex;
                    par[nex] = cur;
                    depth[nex] = depth[cur] + 1;
                }
            }
        }
        return new int[][]{par, q, depth};
    }

    public static int[][] parentToG(int[] par) {
        int n = par.length;
        int[] ct = new int[n];
        for (int i = 0; i < n; i++) {
            if (par[i] >= 0) {
                ct[i]++;
                ct[par[i]]++;
            }
        }
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) {
            g[i] = new int[ct[i]];
        }
        for (int i = 0; i < n; i++) {
            if (par[i] >= 0) {
                g[par[i]][--ct[par[i]]] = i;
                g[i][--ct[i]] = par[i];
            }
        }
        return g;
    }

    public static EulerTour nodalEulerTour(int[][] g, int root) {
        int n = g.length;
        int[] vs = new int[2 * n];
        int[] f = new int[n];
        int[] l = new int[n];
        int p = 0;
        Arrays.fill(f, -1);

        int[] stack = new int[n];
        int[] inds = new int[n];
        int sp = 0;
        stack[sp++] = root;
        outer:
        while (sp > 0) {
            int cur = stack[sp - 1], ind = inds[sp - 1];
            if (ind == 0) {
                vs[p] = cur;
                f[cur] = p;
                p++;
            }
            while (ind < g[cur].length) {
                int nex = g[cur][ind++];
                if (f[nex] == -1) { // child
                    inds[sp - 1] = ind;
                    stack[sp] = nex;
                    inds[sp] = 0;
                    sp++;
                    continue outer;
                }
            }
            inds[sp - 1] = ind;
            if (ind == g[cur].length) {
                vs[p] = cur;
                l[cur] = p;
                p++;
                sp--;
            }
        }

        return new EulerTour(vs, f, l);
    }

    public static class EulerTour {

        public int[] vs; // vertices
        public int[] first; // first appeared time
        public int[] last; // last appeared time

        public EulerTour(int[] vs, int[] f, int[] l) {
            this.vs = vs;
            this.first = f;
            this.last = l;
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            tr(System.currentTimeMillis() - s + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new CFT4().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}
