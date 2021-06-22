import java.util.*;

public class pr1 {

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    static class Student{
        String name;
        String group;
        Student (String name, String group){
            this.name=name;
            this.group=group;
        }

        public String getName() {
            return name;
        }

        public String getGroup() {
            return group;
        }
    }

    public static void main(String[] args) {
        Function <ArrayList<Student>, Map<String, ArrayList<Student>>> function = (a) -> {
            Map<String, ArrayList<Student>> groups = new HashMap<String, ArrayList<Student>>();
            Iterator <Student> iter = a.iterator();
            while(iter.hasNext()){
                Student st = iter.next();
                if (groups.containsKey(st.getGroup())){
                    groups.get(st.getGroup()).add(st);
                }
                else{
                    groups.put(st.getGroup(), new ArrayList<Student>());
                    groups.get(st.getGroup()).add(st);
                }
            }
            return groups;
        };

        ArrayList <Student> students = new ArrayList<Student>();
        students.add(new Student("Stive A.T.", "ooo-2"));
        students.add(new Student("Luke L.L.", "loo-2"));
        students.add(new Student("Nick N.y.", "ooo-2"));
        students.add(new Student("Mike O.T.", "ooo-2"));
        students.add(new Student("Jane A.P.", "loo-2"));
        students.add(new Student("Nina P.P.", "loo-2"));

        Map<String, ArrayList<Student>> group = function.apply(students);

        group.entrySet().forEach(
                (entry) -> {
                    System.out.print(entry.getKey()+": \n");
                    entry.getValue().forEach(
                elem -> {
                    System.out.print(elem.getName()+" ");
                }
                );
                    System.out.print("\n");
                }
                );
    }
}
