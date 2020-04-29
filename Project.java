import java.util.* ;

public class Project {
    public static void main(String[] args) throws Exception {
        int language = Input.askNumber("Valitse kieli: 1) Suomi (fi), 2) English (en)");
        Locale locale;
        if(language == 1) {
            locale = new Locale("fi", "FI");  // käyttäjä valitsi suomen kielen
        } else { 
        locale = new Locale("en", "US"); // käyttäjä valitsi englannin kielen
        }
        //Locale locale = Locale.getDefault(language); tällä komennolla kone automaattisesti valitsisi käyttäjän koneen käyttöjärjestelmän kielen
        ResourceBundle labels = ResourceBundle.getBundle("ui", locale);
                
        Comments.emptyLine(2);
        sleep(1500);
        Comments.hello(locale) ;
        Comments.emptyLine(1);
        String hoursawakening = labels.getString("timequestion1") ;
        int awakeningHours = Input.askNumber(hoursawakening);
        sleep(1000);
        Comments.emptyLine(1);
        String minutesawakening = labels.getString("timequestion2") ;
        int awakeningMinutes = Input.askNumber(minutesawakening);
        sleep(1000);
        Comments.emptyLine(1);
        int aminutes = (60 * awakeningHours) + awakeningMinutes ;
        String hoursschool = labels.getString("timequestion3") ;
        int schoolBeginHours = Input.askNumber(hoursschool);
        sleep(1000);
        Comments.emptyLine(2) ; 
        String minutesschool = labels.getString("timequestion2") ;
        int schoolBeginMinutes = Input.askNumber(minutesschool);
        sleep(1000);
        int sminutes = (60 * schoolBeginHours) + schoolBeginMinutes ;
        Comments.emptyLine(1);
        int wayToSchool = 0 ;
        Input.reactionForAwakeningTime(aminutes, sminutes, locale) ;
        Comments.emptyLine(1);
        String wayToGo = labels.getString("waytoschoolquestion") ;
        int wayToSchoolChoise = Input.askNumber(wayToGo) ;
        sleep(1000);


        while (wayToSchool < 5) {

            if (wayToSchoolChoise == 1) {
                wayToSchool = wayToSchool + 15 ;
                                 
            } else if (wayToSchoolChoise == 2) {
                wayToSchool = wayToSchool + 5 ;
                 
            } 
        }

        Comments.emptyLine(1);
        int timeToGo = sminutes - aminutes - wayToSchool ;
        int choresTermGrade = morningChoresTermGrade() ; // toimienKestoArvio = aamutoimienKestoArvio();
        ArrayList <String> morningChoreList = new ArrayList<>(); //aamutoimilista
        String chore1 = labels.getString("chore1") ;
        morningChoreList.add(chore1) ;
        String chore2 = labels.getString("chore2") ;
        morningChoreList.add(chore2) ;
        String chore3 = labels.getString("chore3") ;
        morningChoreList.add(chore3) ;
        String chore4 = labels.getString("chore4") ;
        morningChoreList.add(chore4) ;
        String chore5 = labels.getString("chore5") ;
        morningChoreList.add(chore5) ;

        String timeToGo1 = labels.getString("timetogo1") ;
        String timeToGo2 = labels.getString("timetogo2") ;
        System.out.println(timeToGo1 + " " + timeToGo + " " + timeToGo2) ;
        sleep(2000);
        Comments.emptyLine(1);
        String chorelist = labels.getString("choresstart") ;
        System.out.println(chorelist) ;
        sleep(2500);
        Comments.emptyLine(1);

        int termOverall = 0 ; //kesto yhteensä
        int choresCount = morningChoreList.size() ; //toimien lukumäärä
        int i = 0 ;
        
        while (i < choresCount && timeToGo > 0) {

            for (i = 0; i < choresCount; i++) {
                System.out.println(morningChoreList.get(i) + " ") ;
                sleep(2500);
                Comments.emptyLine(1);
                String howLong = labels.getString("chorescount") ;                                   
                int term = Input.askNumber(howLong) ; // term = kesto
                sleep(1500);
                Comments.emptyLine(1); 
                termOverall = termOverall + term ;
                timeToGo = timeToGo - term ;
                if (timeToGo > 0) {
                    String startLeft1 = labels.getString("timetogo11") ;
                    String startLeft2 = labels.getString("timetogo12") ;
                    System.out.println(startLeft1 + " " + timeToGo + " " +  startLeft2) ;
                    sleep(1500);
                    Comments.emptyLine(1);
                } else {
                    String leaveNow = labels.getString("mustgo") ;
                    System.out.println(leaveNow) ;
                    sleep(1500);
                    Comments.emptyLine(1);
                    break;
                }               
                   
            }
        }

        if (aminutes + termOverall >= sminutes - 4) {
            String goingComment1 = labels.getString("reactionfortimeleft1") ;
            System.out.println(goingComment1) ;
            sleep(1000);
            Comments.emptyLine(1);
        } else if (aminutes + termOverall + wayToSchool >= sminutes && aminutes + termOverall < sminutes -4 && aminutes + termOverall > sminutes -15) {
            String goingComment2 = labels.getString("reactionfortimeleft2") ;
            System.out.println(goingComment2) ;
            sleep(1000);
            Comments.emptyLine(1);
        } else {
            String goingComment3 = labels.getString("reactionfortimeleft3") ;
            System.out.println(goingComment3) ;
            sleep(1000);
            Comments.emptyLine(1);
        }

        String byebye = labels.getString("finalcomment") ;
        System.out.println(byebye) ;

    }

    public static int morningChoresTermGrade() {
        Scanner lukija = new Scanner(System.in) ;
        ArrayList<Integer> morningChoresTermGrade = new ArrayList<>();
        int wc = 5 ;
        morningChoresTermGrade.add(wc) ;
        int gettingDressed = 5 ;
        morningChoresTermGrade.add(gettingDressed) ;
        int breakfast = 15 ;
        morningChoresTermGrade.add(breakfast) ;
        int packingSchoolbag = 5 ;
        morningChoresTermGrade.add(packingSchoolbag) ;
        int teethBrushing = 3 ;
        morningChoresTermGrade.add(teethBrushing) ;
        
        int sum = 0 ;
        Comments.emptyLine(2) ;

        
        for (int number : morningChoresTermGrade) {
            sum += number ;
            
        }

        return sum ;
        
    }
    
    public static void sleep(int millisecs) {
        try {
           Thread.sleep(millisecs);
        } catch(Exception e) {
           e.printStackTrace();
        }
    }

}

