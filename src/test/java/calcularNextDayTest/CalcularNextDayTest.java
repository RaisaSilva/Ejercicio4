package calcularNextDayTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalcularNextDayTest {


        private int day;
        private int year;
        private int hour;
        private int min;
        private String month;
        private int sec;
        private String expectedResult;

        public CalcularNextDayTest(int day, String month, int year, int hour, int min, int sec, String expectedResult){
            this.day = day;
            this.month = month;
            this.year = year;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.expectedResult = expectedResult;

        }
        @Parameterized.Parameters
        public static Iterable<Object[]> getData() {
            List<Object[]> objects = new ArrayList<>();

            objects.add(new Object[]{1, "Enero", 2020,  23, 59, 59, "2 Enero 2020 00:00:00" });
            objects.add(new Object[]{1, "Febrero", 2020,  23, 59, 59, "2 Febrero 2020 00:00:00" });
            objects.add(new Object[]{1, "Marzo", 2020,  23, 59, 59, "2 Marzo 2020 00:00:00" });
            objects.add(new Object[]{1, "Abril", 2020,  23, 59, 59, "2 Abril 2020 00:00:00" });
            objects.add(new Object[]{1, "Mayo", 2020,  23, 59, 59, "2 Mayo 2020 00:00:00" });
            objects.add(new Object[]{1, "Junio", 2020,  23, 59, 59, "2 Junio 2020 00:00:00" });
            objects.add(new Object[]{1, "Julio", 2020,  23, 59, 59, "2 Julio 2020 00:00:00" });
            objects.add(new Object[]{1, "Agosto", 2020,  23, 59, 59, "2 Agosto 2020 00:00:00" });
            objects.add(new Object[]{1, "Septiembre", 2020,  23, 59, 59, "2 Septiembre 2020 00:00:00" });
            objects.add(new Object[]{1, "Octubre", 2020,  23, 59, 59, "2 Octubre 2020 00:00:00" });
            objects.add(new Object[]{1, "Noviembre", 2020,  23, 59, 59, "2 Noviembre 2020 00:00:00" });
            objects.add(new Object[]{1, "Diciembre", 2020,  23, 59, 59, "2 Diciembre 2020 00:00:00" });
            objects.add(new Object[]{31, "Enero", 2020,  23, 59, 59, "1 Febrero 2020 00:00:00" });
            objects.add(new Object[]{28, "Febrero", 2021,  23, 59, 59, "1 Marzo 2021 00:00:00" });
            objects.add(new Object[]{29, "Febrero", 2020,  23, 59, 59, "1 Marzo 2020 00:00:00" });//---- bisiesto
            objects.add(new Object[]{31, "Marzo", 2020,  23, 59, 59, "1 Abril 2020 00:00:00" });
            objects.add(new Object[]{30, "Abril", 2020,  23, 59, 59, "1 Mayo 2020 00:00:00" });
            objects.add(new Object[]{31, "Mayo", 2020,  23, 59, 59, "1 Junio 2020 00:00:00" });
            objects.add(new Object[]{30, "Junio", 2020,  23, 59, 59, "1 Julio 2020 00:00:00" });
            objects.add(new Object[]{31, "Julio", 2020,  23, 59, 59, "1 Agosto 2020 00:00:00" });
            objects.add(new Object[]{31, "Agosto", 2020,  23, 59, 59, "1 Septiembre 2020 00:00:00" });
            objects.add(new Object[]{30, "Septiembre", 2020,  23, 59, 59, "1 Octubre 2020 00:00:00" });
            objects.add(new Object[]{31, "Octubre", 2020,  23, 59, 59, "1 Noviembre 2020 00:00:00" });
            objects.add(new Object[]{30, "Noviembre", 2020,  23, 59, 59, "1 Diciembre 2020 00:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  23, 59, 59, "1 Enero 2021 00:00:00" });

            objects.add(new Object[]{20, "Febrero", -1, 23, 59, 59, "AÑO INCORRECTO..." });//- Invalid Year
            objects.add(new Object[]{31, "Febrero", 2020,  23, 59, 59, "DIA INOCRRECTO..." });// - Invalid Day
            objects.add(new Object[]{31, "Diciembres", 2020,  23, 59, 59, "MES INCORRECTO..." });//- Invalid Month

            objects.add(new Object[]{31, "Diciembre", 2020,  -1, 59, 59, "HORA INOCRRECTO..." });//---- Invalid Hour
            objects.add(new Object[]{31, "Diciembre", 2020,  00, 59, 59, "31 Diciembre 2020 01:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 59, 59, "31 Diciembre 2020 02:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020, 11, 59, 59, "31 Diciembre 2020 12:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  12, 59, 59, "31 Diciembre 2020 13:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  13, 59, 59, "31 Diciembre 2020 14:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  22, 59, 59, "31 Diciembre 2020 23:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  23, 59, 59, "1 Enero 2021 00:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  24, 59, 59, "HORA INOCRRECTO..." });//---- Invalid Hour

            objects.add(new Object[]{31, "Diciembre", 2020, 01, -1, 59, "MIN INOCRRECTO..." }); //---- Invalid Minute
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 00, 59, "31 Diciembre 2020 01:01:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 59, "31 Diciembre 2020 01:02:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 29, 59, "31 Diciembre 2020 01:30:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 30, 59, "31 Diciembre 2020 01:31:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 31, 59, "31 Diciembre 2020 01:32:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 58, 59, "31 Diciembre 2020 01:59:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 59, 59, "31 Diciembre 2020 02:00:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 60, 59, "MIN INOCRRECTO..." });//---- Invalid Minute

            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, -1, "SEC INOCRRECTO..." }); //---- Invalid Second
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 00, "31 Diciembre 2020 01:01:01" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 01, "31 Diciembre 2020 01:01:02" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 29, "31 Diciembre 2020 01:01:30" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 30, "31 Diciembre 2020 01:01:31" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 31, "31 Diciembre 2020 01:01:32" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 58, "31 Diciembre 2020 01:01:59" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 59, "31 Diciembre 2020 01:02:00" });
            objects.add(new Object[]{31, "Diciembre", 2020,  01, 01, 60, "SEC INOCRRECTO..." }); //---- Invalid Second

            objects.add(new Object[]{39, "Dragon", -1000,  25, 69, 80, "AÑO INCORRECTO..." }); //----> Invalid Day

            return objects;
        }
    @Test
    public void verify_hora_fecha(){

        CalcularNextDay calcularNextDay = new CalcularNextDay();
        String actualResult= calcularNextDay.CalcularFecha(this.day, this.month, this.year, this.hour, this.min, this.sec);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);

    }
}


