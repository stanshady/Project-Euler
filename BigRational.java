import java.math.BigInteger;

public class BigRational
{

    public static final BigRational ONE = new BigRational(BigInteger.ONE, BigInteger.ONE);
    public static final BigRational ZERO = new BigRational(BigInteger.ZERO, BigInteger.ONE);
    public static final BigRational NEG1 = new BigRational(
            new BigInteger(Integer.toString(-1)), BigInteger.ONE);
    private BigInteger numer;
    private BigInteger denom;

    BigRational(BigInteger numerator, BigInteger denominator)
    {
        numer = numerator;
        denom = denominator;
    }

    public BigRational multiply(BigRational frac)
    {
        BigRational result = new BigRational(numer.multiply(frac.getNumer()), denom.multiply(frac.getDenom()));
        return result.simplify();
    }

    public BigRational divide(BigRational frac)
    {
        BigRational result = new BigRational(numer.multiply(frac.getDenom()), denom.multiply(frac.getNumer()));
        return result.simplify();
    }

    public BigRational add(BigRational frac)
    {
        BigInteger tempN = numer.multiply(frac.getDenom()).add(frac.getNumer().multiply(denom));
        BigInteger tempD = denom.multiply(frac.getDenom());
        BigRational result = new BigRational(tempN, tempD);
        return result.simplify();
    }

    public BigRational subtract(BigRational frac)
    {
        return this.add(frac.multiply(NEG1)).simplify();
    }

    public BigRational simplify()
    {
        BigInteger gcd = numer.gcd(denom);

        if(denom.compareTo(BigInteger.ZERO) < 0)
        {
            numer = numer.multiply(new BigInteger(Integer.toString(-1)));
            denom = denom.multiply(new BigInteger(Integer.toString(-1)));
        }

        BigRational result = new BigRational(numer.divide(gcd), denom.divide(gcd));
        return result;
    }

    public boolean equals(BigRational frac)
    {
        return this.simplify().numer.equals(frac.simplify().numer)
        && this.simplify().denom.equals(frac.simplify().denom);
    }

    public BigInteger getNumer()
    {
        return numer;
    }

    public BigInteger getDenom()
    {
        return denom;
    }

    public void setNumer(BigInteger numerator)
    {
        numer = numerator;
    }

    public void setDenom(BigInteger denominator)
    {
        denom = denominator;  
    }

    public String toString()
    {
        if(denom.equals(BigInteger.ONE))
            return "" + numer.toString();
        else
            return numer.toString() + "/" + denom.toString();
    }
}
