import java.util.List;

public class Polynome {

    private int coeff;
    private int deg; //deg >= 0
    private Polynome suiv;

    public Polynome(int c, int d, Polynome p) {
        coeff = c;
        deg = d;
        suiv = p;
    }

    public static void main(String[] args) {
        Polynome p = new Polynome(3, 2, null);
        Polynome p1 = new Polynome(2, 1, p);
        Polynome p2 = new Polynome(1, 2, p1);
        Polynome p3 = new Polynome(2, -2, p2);

        Polynome polynome = simplifie(p2);
        System.out.println(toString(polynome));
        //System.out.println(toString(p3));
        //Polynome polynome1 = reduire(p3);
        //System.out.println(toString(polynome1));


    }

    public static String toString(Polynome p) {
        if (p.suiv == null) {
            if (p.coeff >= 0)
                return "+" + p.coeff + "x" + "^" + p.deg;
            else {
                return p.coeff + "x" + "^" + p.deg;
            }
        } else {
            if (p.coeff >= 0) {
                return "+" + p.coeff + "x" + "^" + p.deg + toString(p.suiv);
            } else {
                return p.coeff + "x" + "^" + p.deg + toString(p.suiv);

            }
        }
    }

    public static int eval(Polynome p, int x) {
        if (p.suiv == null) {
            return (int) (p.coeff * Math.pow(x, p.deg));
        } else {
            int tmp = (int) (p.coeff * Math.pow(x, p.deg));
            return tmp + eval(p.suiv, x);
        }
    }

    public static int degre(Polynome p) {
        if (p.suiv == null) {
            return p.deg;
        } else {
            if (p.coeff != 0 && p.suiv.coeff != 0) {
                int res = Math.max(p.deg, degre(p.suiv));
                return res;
            }
            return 0;
        }
    }

    public static Polynome simplifie(Polynome p) {
        if (p.suiv == null) {
            if (p.coeff != 0) {
                return new Polynome(p.coeff, p.deg, null);
            }
            else{
                return null;
            }
        } else {
            if (p.coeff != 0) {
                Polynome pol = new Polynome(p.coeff, p.deg, null);
                pol.suiv= simplifie(p.suiv);
                return pol;
            }
        }
        return simplifie(p.suiv);
    }

    /*public static Polynome reduire(Polynome p) {
        if
    }*/
}
