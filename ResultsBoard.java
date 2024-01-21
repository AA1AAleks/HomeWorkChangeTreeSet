package BTreeSetAndMap;

import java.util.*;

public class ResultsBoard {


    TreeMap<String, Float> nameAndScore = new TreeMap<>();
    TreeSet<Students> allStudents = new TreeSet<>();

    public void addStudent(String name, Float grade){
        Students student = new Students();
        student.name = name;
        student.grade = grade;
        nameAndScore.put(student.name, student.grade);
        allStudents.add(student);

    }
    List<String> top3Stud(int n) throws NullPointerException{
       if (n < 0){
           throw new NegativeArraySizeException();
       }
       if(n > allStudents.size()){
          n = allStudents.size();
       }
       List<Students> sort = new ArrayList<>(allStudents);
       Collections.sort(sort, Collections.reverseOrder());

       List<String> topNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {

                topNames.add(sort.get(i).name);
            }

            return topNames;
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();

        resultsBoard.addStudent("Jon", 4.3f);
        resultsBoard.addStudent("Pit", 6.7f);
        resultsBoard.addStudent("Sam", 7.2f);
        resultsBoard.addStudent("Don", 5.0f);
        resultsBoard.addStudent("Yen", 8.8f);
        resultsBoard.addStudent("Li", 9.1f);


        System.out.println("Имeна и оценки \n" + resultsBoard.nameAndScore);
        System.out.println("Оценки по возрастанию \n" + resultsBoard.allStudents);
        System.out.println("Лучшие студенты \n" + resultsBoard.top3Stud(3));
    }
}

class Students implements Comparable<Students>{
    String name;
    Float grade;

    public Students(String name, Float grade) {
        this.name = name;
        this.grade = grade;
    }


    public Students() {

    }

    @Override
    public String toString() {
        return "Student -" +
                "name -" + name +
                "- grade = " + grade ;
    }


    @Override
    public int compareTo(Students o) {
        return this.grade.compareTo(o.grade);
    }
}


