package ComparatorExample

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 03/09/14
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 */
class StudentImpl {
    public static void main(String[] args) {
        Student student1 = new Student(25)
        Student student2 = new Student(23)
        Student student3 = new Student(77)
        Student student4 = new Student(99)

        StudentComparator studentComparator = new StudentComparator()
        List<Student> listStudent =Arrays.asList(student1, student2, student3, student4)
        Collections.sort(listStudent, studentComparator)
        println listStudent.collect{it.mathsMark}
    }
}
