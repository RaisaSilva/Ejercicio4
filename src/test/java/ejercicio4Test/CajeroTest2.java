package ejercicio4Test;

import ejercicio4.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest({BDUtilS.class, ClientDBS.class})

public class CajeroTest2 {

    @Parameterized.Parameter(0)
    private int ci;
    @Parameterized.Parameter(1)
    private int saldo;
    @Parameterized.Parameter(2)
    private int amount;
    @Parameterized.Parameter(3)
    private String expectedResult;
    @Parameterized.Parameter(4)
    private boolean conecBD;
    @Parameterized.Parameter(5)
    private boolean actualizacion;


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

    @Test
    public void verify_calculate_amount(){
        PowerMockito.mockStatic(BDUtil.class);
        PowerMockito.mockStatic(ClientDB.class);
        Mockito.when(ClientDBS.isConnectionSuccessfullyStatic("mysql")).thenReturn(this.conecBD);
        Mockito.when(BDUtilS.updateSaldoStatic(this.ci, this.saldo - this.amount)).thenReturn(this.actualizacion);

        Cajero2 cajero = new Cajero2(saldo);
        String actualResult = cajero.getCash(this.ci, this.amount);
        Assert.assertEquals("ERROR! ", this.expectedResult, actualResult);
    }
}
