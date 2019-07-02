package demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import demo.models.Student;



@Controller
public class SimpleController {

	private ArrayList<Student> students = new ArrayList<>();
	
	@GetMapping(value="/index")
	public String indexPage()
	{
		return "index";
	}
	
	@GetMapping(value="/view")
	public String view(Model model)
	{
		model.addAttribute("students", students);
		return "viewall";
	}
	@GetMapping(value="/view/{id}")
	public String viewById(@PathVariable (name="id") int id, Model model)
	{
		//TODO parbaudit, vai ir tads id
		model.addAttribute("student", students.get(id));
		return "viewone";
		
	}
	
	@GetMapping(value="/insert")
	public String insertGet(Student student)
	{
		return "insert";
	}
	
	@PostMapping(value="/insert")
	public String insertPost(Student student)
	{
		Student s = new Student(student.getName(), student.getAge());
		students.add(s);
		return "redirect:/view";
	}
	
	@GetMapping(value="/update/{id}")
	public String updateGet(@PathVariable(name="id") int id, Student student, Model model)
	{
		model.addAttribute("student", students.get(id));
		return "update";
	}
	
	@PostMapping(value="/update/{id}")
	public String updatePost(@PathVariable(name="id") int id, Student student)
	{
		if(student.getName()!=null)
			students.get(id).setName(student.getName());
		
		if(student.getAge()!=0)
			students.get(id).setAge(student.getAge());
		return "redirect:/view";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteGetById(@PathVariable(name="id") int id, Model model, Student student)
	{
		students.remove(id);
		return "redirect:/view";
	}
	
	@GetMapping(value="/delete")
	public String deleteGet( Model model, Student student)
	{
		
		model.addAttribute("students", students);
		return "deletetest";
	}
	
	@PostMapping(value="/delete")
	public String deletePost(Student student)
	{
		System.out.println(student);
		
		for(Student s:students)
			if(s.getId()==student.getId())
			{
				students.remove(s);
				break;
			}
		return "redirect:/view";
	}
	
	
	
}
