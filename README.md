Lab 
---------------

    Eclipse/STS latest
    JDK 1.8

Interfaces vs Abstract Classes
-----------------------------------------------

    interfaces are alwasy the first choice than
    Abstract Classes unless we need fields .

java packages
-----------------------------------------------

    java.lang
    java.time
    java.util
    java.util.function
    java.util.regex
    java.util.streams
    java.io
    java.nio

Expectations
---------------------------------------------------

    Object class 
        significance  of hashcode,toString,clone,equals
        significance  oF getClass
        significance  of wait,yeild,notify and notifyAll

    Wrapper Classes
    Boxing and UnBoxing
        
        int x = 45;
        Integer obj = new Integer(x); //boxing
        int y = obj.getValue(); //unboxing

    AutoBoxing and AutoUnBoxing

        int x = 45;
        Integer obj = x; //auto-boxing
        int y = obj//auto-unboxing

    String
        why are strings immutable ?
        aware of all string constructors
        aware of string methods length,toLowerCase,toUpperCase,getBytes,indexOf,split,substring,join,..

    StringBuffer (is thread safe hence is slow performing) and StringBuilder (is not thread safe and is fast performing)

    Math
        aware of all of its methods

    Exceptions and ExceptionHandling

            Throwable (I)
                |
                |-Error
                |
                |-Exception                     <---------- CHECKED
                        |- RuntimeException     <---------- UNCHECKED

        aware types of Exceptions - Checked and UnChecked
        what is the purpose of UnChecked? why can't we have all Exceptions as Checked?

        UnChecked Exception are ignore by the compiler 
            because "UnChekced Exceptions are not suppsoed to be handled"
            but "UnChecked Exceptiosn must be avoided logically"

            class EmployeeService{
                public void increment(Employee emp,double percent){
                    if(emp!=null){
                        emp.setSalary(emp.getSalary() + (emp.getSalary()*percent));
                    }
                }
            }

Try-with resources and try with multiCatch
-------------------------------------------------------------

    try{
        //do try some operation here.....
    }catch(ExceptionType1 | ExceptionType2 | ExcetionType3 exp){
        //do handle the exception
    }

    try (Connection con = DriverManger.getConnection(.....)){
        //con gets closed automatically irrespective of an exception after try block.   
    }catch(SQLException exp){

    }

java.time
-------------------------------------------------------

    LocalDate       .now(),.of(year,month,date)
    LocalDateTime   .now(),.of(year,month,date,hour,minute,second)
    ZonedDateTime   .now(ZoneId)

                format
                parse

    DateTimeFormatter  .ofPattern("")
                        dd
                        MM
                        MMM
                        MMMM
                        yy
                        yyyy
                        hh
                        HH
                        mm
                        ss
                        a

    Duration            .between        distence b/w two times
    Period              .between        distence b/w two dates

java.util
-------------------------------------------------------

    utitlity legacy classes
        Scanner
        Random
    
    collections is java's approach to data-structures

        Generics and WildCards

        Collection      add,remove,contains,size,isEmpty,stream
            |- List     index based operatiosn and duplicate entires and multiple nulls are possible
            |- Set      no duplicate entries and a maximum of single null are possible, and no index based operations

        Map             put,set,get,isEmpty,size,containsKey,containsValue,keySet

            List Implementations
                Vector              growable array and is synchronized/thread-safe
                ArrayList           growable array
                LinkedList          double-linked list

            Set Implementations
                HashSet             does not guarentee any order for retrival
                TreeSet             guarentees sorted order for retrival
                LinkedHashSet       guarentees entry order for retrival

            java.lang.Comprable     default comparision strategy
            java.util.Comparator    additional / customized comparasion

            Map Implementations
                HashMap             does not guarentee any order for retrival
                TreeMap             guarentees sorted on keys order for retrival 
                LinkedHashMap       guarentees entry order for retrival

        Collections

    functional interfaces, lambda expressions and streams api
