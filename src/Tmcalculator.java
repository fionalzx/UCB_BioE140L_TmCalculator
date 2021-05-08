import java.util.Hashtable;
import static java.lang.Math.*;

/**
 *
 * @author Zixin Fiona Lin
 */
public class Tmcalculator {

    Hashtable<String, Double> deltaH = new Hashtable<String, Double>();
    Hashtable<String, Double> deltaS = new Hashtable<String, Double>();

    /**
     * create dictionary for unified oligonucleotide ΔH° and ΔS° NN parameters in 1M NaCl
     * based on SantaLucia J Jr. (1998) PNAS, 95:1460-5
     */
    public void initiate() throws Exception {

        deltaH.put("TT", -7.9);
        deltaH.put("AA", -7.9);
        deltaH.put("AT", -7.2);
        deltaH.put("TA", -7.2);
        deltaH.put("CA", -8.5);
        deltaH.put("AC", -8.5);
        deltaH.put("GT", -8.4);
        deltaH.put("TG", -8.4);
        deltaH.put("CT", -7.8);
        deltaH.put("TC", -7.8);
        deltaH.put("GA", -8.2);
        deltaH.put("AG", -8.2);
        deltaH.put("CG", -10.6);
        deltaH.put("GC", -9.8);
        deltaH.put("GG", -8.0);
        deltaH.put("CC", -8.0);

        deltaS.put("TT", -22.2);
        deltaS.put("AA", -22.2);
        deltaS.put("AT", -20.4);
        deltaS.put("TA", -21.3);
        deltaS.put("CA", -22.7);
        deltaS.put("AC", -22.7);
        deltaS.put("GT", -22.4);
        deltaS.put("TG", -22.4);
        deltaS.put("CT", -21.0);
        deltaS.put("TC", -21.0);
        deltaS.put("GA", -22.2);
        deltaS.put("AG", -22.2);
        deltaS.put("CG", -27.2);
        deltaS.put("GC", -24.4);
        deltaS.put("GG", -19.9);
        deltaS.put("CC", -19.9);
    }


    public double run(String seq){
        seq = seq.toUpperCase();
        double H = computesDelta(seq)[0];
        double S = computesDelta(seq)[1];
        double PrimerConcentration = 0.0000002;
        double NaConcentration = 0.05;
        double Tm = abs(H) * 1000 / (abs(S) + 1.987 * log(1 / PrimerConcentration)) + 16.6 * log10(NaConcentration) - 273.15;
        return Tm;
    }


    /**
     * computes ΔH° and ΔS° with unified oligonucleotide NN parameters
     * @return ΔH° in kcal/mol, ΔS° in cal/k·mol
     */
    private double[] computesDelta(String seq){

        double initialH = 0;
        double initialS = 0;

        int length = seq.length();
        String first = seq.substring(0, 1);
        String last = seq.substring(length - 1, length);

        if (first.equals("A") | first.equals("T")){
            initialH += 2.3;
            initialS += 4.1;
        } else {
            initialH += 0.1;
            initialS += -2.8;
        }

        if (last.equals("A") | last.equals("T")){
            initialH += 2.3;
            initialS += 4.1;
        } else {
            initialH += 0.1;
            initialS += -2.8;
        }

        for (int i = 0; i < seq.length() - 1; i++){
            String oligo = seq.substring(i, i + 2);
            initialH += deltaH.get(oligo);
            initialS += deltaS.get(oligo);
        }

        double[] HS = new double[] {initialH, initialS};
        return HS;
    }


    public static void main(String[] args) throws Exception {
        Tmcalculator tmCalculator = new Tmcalculator();
        tmCalculator.initiate();
        double result = tmCalculator.run("ccaaaAGATCTatgagcggcttcccccgcag");
        System.out.println("Tm is: " + result);
    }
}