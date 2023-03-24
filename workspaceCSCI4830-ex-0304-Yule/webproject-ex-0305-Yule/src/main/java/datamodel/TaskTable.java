package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taskTable")
public class TaskTable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "taskname")
   private String taskname;

   @Column(name = "category")
   private String category;
   
   @Column(name = "deadline")
   private String deadline;

   @Column(name = "priority")
   private String priority;
   
   public TaskTable() {
   }

   public TaskTable(Integer id, String taskname, String category, String deadline, String priority) {
      this.id = id;
      this.taskname = taskname;
      this.category = category;
      this.deadline = deadline;
      this.priority = priority;
   }

   public TaskTable(String taskname, String category, String deadline, String priority) {
      this.taskname = taskname;
      this.category = category;
      this.deadline = deadline;
      this.priority = priority;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return taskname;
   }

   public void setName(String name) {
      this.taskname = name;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getDeadline() {
	      return deadline;
	   }

   public void setDeadline(String deadline) {
	   this.deadline = deadline;
	   }
   
   public String getPriority() {
	   return priority;
   }
   
   public void setPriority(String priority) {
	   this.priority = priority;
   }
      
   @Override
   public String toString() {
      return "Task: " + this.id + ", " + this.taskname + ", " + this.category + ", " + this.deadline + ", " + this.priority;
   }
}