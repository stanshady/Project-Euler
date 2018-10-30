/* This class creates objects that behave like rational
 * numbers.  Dividing by zero will crash.
 */
public class Rational
{
    public static final Rational ONE = new Rational(1, 1);
    public static final Rational ZERO = new Rational(0, 1);
    public static final Rational NEG1 = new Rational(-1, 1);
    private long numer;
    private long denom;

    Rational(long numerator, long denominator)
    {
        numer = numerator;
        denom = denominator;
    }

    public Rational multiply(Rational frac)
    {
        Rational result = new Rational(numer * frac.getNumer(), denom * frac.getDenom());
        return result.simplify();
    }

    public Rational divide(Rational frac)
    {
        Rational result = new Rational(numer * frac.getDenom(), denom * frac.getNumer());
        return result.simplify();
    }

    public Rational add(Rational frac)
    {
        long tempN = numer * frac.getDenom() + frac.getNumer() * denom;
        long tempD = denom * frac.getDenom();
        Rational result = new Rational(tempN, tempD);
        return result.simplify();
    }

    public Rational subtract(Rational frac)
    {
        return this.add(frac.multiply(NEG1)).simplify();
    }

    public long gcd(long a, long b)
    {     
        while(b != 0)
        {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public Rational simplify()
    {
        long gcd = Math.abs(gcd(numer, denom));
        if(denom < 0)
        {
            numer *= -1;
            denom *= -1;
        }
        Rational result = new Rational(numer / gcd, denom / gcd);
        return result;
    }

    public long compareTo(Rational frac)
    {
        long left = numer * frac.getDenom();
        long right = denom * frac.getNumer();
        if(left > right)
            return 1;
        if(left < right)
            return -1;
        return 0;
    }

    public boolean equals(Rational frac)
    {
        return this.simplify().numer == frac.simplify().numer
        && this.simplify().denom == frac.simplify().denom;
    }
    
    public long getNumer()
    {
        return numer;
    }

    public long getDenom()
    {
        return denom;
    }

    public void setNumer(long numerator)
    {
        numer = numerator;
    }

    public void setDenom(long denominator)
    {
        denom = denominator;  
    }

    public String toString()
    {
        if(denom == 1)
            return "" + numer;
        else
            return numer + "/" + denom;
    }

}