package calcularNotasTest;

import ejercicio1.CalcularNota;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CalcularNotasParameters {

    private int firstNota;
    private int secondNota;
    private int thirdNota;
    private String expectedResult;

    public CalcularNotasParameters(int firstNota, int secondNota, int thirdNota, String expectedResult){
        this.firstNota =firstNota;
        this.secondNota=secondNota;
        this.thirdNota=thirdNota;
        this.expectedResult=expectedResult;
    }

    /**
     * Test 1 ---- 0 (positive test)
     * Test 2 ---- 100 (positive test)
     * Test 3 ---- 101 (negative test)
     * Test 4 ---- 99 (positive test)
     * Test 5 ---- 1 (positive test)
     * Test 6 ----  -1 (negative test)
     * Test 7 ---- 49 (positive test)
     * Test 8 ---- 50 (positive test)
     * Test 9 ---- 51 (positive test)
     * >=
     * 90 - 100  Excelente su nota es : NN -----> 90 --- 100
       >=    <
     * 80 - 90  Muy Bien su nota es : NN ---->  80 --- 90
     * 71 - 80  Bien su nota es : NN  ----> 71 --- 80
     * 0 - 71  Esfuerzate mas, su nota es : NN ---->  0----71
     * *** INGRESE DATOS CORRECTOS ***
     * @return
     */

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]>objects= new ArrayList<>();
        objects.add(new Object[]{0,0,0,"Esfuerzate mas, su nota es : 0"});
        objects.add(new Object[]{100,100,100,"Excelente su nota es : 100"});
        objects.add(new Object[]{101,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{99,80,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{1,80,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{-1,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{49,80,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{50,80,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{51,80,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,0  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,100,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,101,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,99 ,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,1  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,-1 ,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,49 ,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,50 ,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,51 ,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,80,0  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,100,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,101,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,99 ,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,1  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,-1 ,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,49 ,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,80,50 ,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,80,51 ,"Esfuerzate mas, su nota es : 70"});

        return objects;
    }


    @Test
    public void verify_suma_all_values(){

        CalcularNota calculaNota = new CalcularNota();
        String actualResult= calculaNota.notaFinal(this.firstNota,this.secondNota,this.thirdNota);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);

    }



}
