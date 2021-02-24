package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)

public class CajeroTest {

    private int ci;
    private int saldo;
    private int amount;
    private String expectedResult;
    private boolean conecBD;
    private boolean actualizacion;

    public CajeroTest(int ci, int saldo, int amount, String expectedResult, boolean conecBD, boolean actualizacion){
        this.ci = ci;
        this.saldo = saldo;
        this.amount = amount;
        this.expectedResult = expectedResult;
        this.conecBD = conecBD;
        this.actualizacion = actualizacion;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{68111890, 0,    500, "Usted no tiene suficiente saldo", true, true});
        objects.add(new Object[]{68111891, 1,    500, "Usted no tiene suficiente saldo", true, true});
        objects.add(new Object[]{68111892, 499,  500, "Usted no tiene suficiente saldo", true, true});
        objects.add(new Object[]{68111893, 500,  500, "Usted esta sacando la cantidad de 500 y tiene en saldo 0", true, true});
        objects.add(new Object[]{68111894, 501,  500, "Usted esta sacando la cantidad de 500 y tiene en saldo 1", true, true});
        objects.add(new Object[]{68111895, 999,  500, "Usted esta sacando la cantidad de 500 y tiene en saldo 499", true, true});
        objects.add(new Object[]{68111896, 1000, 500, "Usted esta sacando la cantidad de 500 y tiene en saldo 500", true, true});
        objects.add(new Object[]{68111897, 1001, 500, "Usted esta sacando la cantidad de 500 y tiene en saldo 501", true, true});
        objects.add(new Object[]{68111898, 1000,-500, "Amount No Valido", true, true});

        objects.add(new Object[]{68111899, 2000, 500, "Conexion a BD no fue satisfactoria", true, false});
        objects.add(new Object[]{68111810, 2000, 500, "Actualizacion Incorrecta, Intente Nuevamente", false, true});
        objects.add(new Object[]{68111811, 2000, 500, "Conexion a BD no fue satisfactoria", false, false});

        return objects;

    }

    BDUtil bdUtilMocked = Mockito.mock(BDUtil.class);
    ClientDB clientDBMocked = Mockito.mock(ClientDB.class);

    @Test
    public void verify_get_cash(){
        Cajero cajero = new Cajero(this.saldo,bdUtilMocked,clientDBMocked);
        // 3
        Mockito.when(bdUtilMocked.updateSaldo(this.ci,this.saldo-this.amount)).thenReturn(this.actualizacion);
        Mockito.when(clientDBMocked.isConnectionSuccessfully("mysql")).thenReturn(this.conecBD);

        // 4
        Assert.assertEquals("ERROR: ", expectedResult, cajero.getCash(this.ci, this.amount));

    }
}
