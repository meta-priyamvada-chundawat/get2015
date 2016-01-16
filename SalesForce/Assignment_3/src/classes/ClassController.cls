public class ClassController {
    //Create a class and a static function which take classid as argument and returns all names of the students in that class as a list.
    public static List<Student__c> getStudentList(ID id){
        List<Student__c> studentList=[Select s.Name,s.LastName__c from Student__c s where s.class__r.id=:id];
        System.debug(studentList);
        return studentList;
    }
    
    public static Map<Class__c,Set<ID>> getMapOfClass(){
        List<Class__c> classList=[select c.ID,c.Name from Class__c c];
        Map<Class__c,Set<ID>> map1=new Map<Class__c,Set<ID>>();
        for(Integer i=0; i<classList.size();i++){
         	Set<ID> studentSet= new Map<Id, Student__c>([Select s.ID from Student__c s where s.Class__r.id=:classList.get(i).Id ]).keySet();
       		map1.put(classList.get(i),studentSet);
        }
         System.debug(map1);
      return map1;
    }
    public static Integer getWorkingDays(Date startDate,Date dueDate){
      
        Date instance=Date.newInstance(1900, 1, 7);
        Integer count=0; 
        Integer value=math.mod(startDate.daysBetween(instance), 7);
        
        Integer numberDaysDue = startDate.daysBetween(dueDate)+1;
        System.debug(numberDaysDue);
        
        Integer rem=math.mod(numberDaysDue, 7);
        
        Date tempDate = dueDate.addDays(-(rem-1));
        
        
        Integer weeks = numberDaysDue/7;
        for(Integer i = 0; i< rem; i++) {
            if(math.mod(instance.daysBetween(tempDate), 7)>=1 && math.mod(instance.daysBetween(tempDate), 7)<=5)  {
              count++;
            }
            System.debug(count+'tggggggg   '+math.mod(instance.daysBetween(tempDate), 7));
             tempDate=tempDate.addDays(1);
        }
        count = count+5*weeks;
        System.debug(numberDaysDue+'dscgfhj     '+count);
		return count;
    } 
}