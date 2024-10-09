public class Date {
   private int dd;
    private int mm;
    private int yyyy;

    public Date(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
    }

    static boolean isleapYear(int yyyy){
        if(yyyy%4==0){
            return true;
        }
        return false;
    }

    static int  getNumberDaysInMonth(int mm,int yyyy){
        int[]months={31,28,31,30,31,30,31,31,30,31,30,31};
        if(mm==2){
            if(isleapYear(yyyy)){
                months[1]++;
            }
        }
        return months[mm-1];
    }


    static int  getDayNumberOfYear(int dd,int mm,int yyyy){
        int dn=0;
        for (int month=1;month<mm;month++){
            dn +=getNumberDaysInMonth(month,yyyy);
        }
        dn+=dd;
        return dn;
    }

    private static int getNumberofDaysinYear(int yyyy) {
        if(isleapYear(yyyy)){
            return 366;
        }
        return 365;
    }

    public void findDateAfterNDays(int n){
        int dn=getDayNumberOfYear(this.dd,this.mm,this.yyyy);
        int dn2=dn+n;
        while(dn2>getNumberofDaysinYear(this.yyyy)){
            dn2-=getNumberofDaysinYear(this.yyyy);
           this.yyyy++;
        }
        int mm2=1;
        while (dn2>getNumberDaysInMonth(mm2,this.yyyy)){
            dn2-=getNumberDaysInMonth(mm2,this.yyyy);
            mm2++;
        }
        int dd2=dn2;
        System.out.println("After"+n+" days");
        printDate(dd2,mm2,this.yyyy);
    }
    public void findDateBeforeNDays(int n){
        int dd2=getDayNumberOfYear(dd,mm,yyyy);
        dd2=dd2-n;
//        System.out.println(dd2);
        while(dd2<getNumberofDaysinYear(yyyy) &&dd2<0){
            yyyy--;
            dd2+=getNumberofDaysinYear(yyyy);
//            System.out.println(dd2);
//            yyyy--;
        }
        int mn=mm;
        while (dd2>getNumberDaysInMonth(mn,yyyy) ){
            dd2-=getNumberDaysInMonth(mn,yyyy);
            mn++;
            if(mn==13){
                mn=1;
            }
        }
        System.out.println("before"+n+" days");
        printDate(dd2,mn,yyyy);
    }

    private static void printDate(int dd2, int mm2, int yyyy) {
        System.out.println(dd2+"-"+mm2+"-"+yyyy);
    }
\
}
