
package com.example.aula04.controle;
import javax.validation.constraints.Null;
import com.example.aula04.entidade.Professor;
import com.example.aula04.servico.ProfessorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProfessorControle {

    @Autowired
    private ProfessorServico professorServico;

    
    @GetMapping("/professores")
    public ModelAndView getProfessores(){
        
        ModelAndView mv = new ModelAndView("professoresTemplate");
    
        mv.addObject("professor",  new Professor());
        mv.addObject("professores", professorServico.getProfessores());
        
        
        return mv;
    }

    @GetMapping("/removerProfessor")
    public String removerProfessor(@RequestParam Integer codigo){
        
        Professor professor = professorServico.getProfessorById(codigo);
        professorServico.remover(professor);

        return "redirect:/professores";
    }

    @GetMapping("/editarProfessor")
    public ModelAndView editarProfessor(@RequestParam Integer codigo){
        
        ModelAndView mv = new ModelAndView("professorEdit");
    
        Professor professor = professorServico.getProfessorById(codigo); 
        mv.addObject("professor",  professor);
       

        return mv;
   
    }

    @PostMapping("/salvarProfessor")
    public String salvar(@ModelAttribute Professor professor){
        professorServico.salvar(professor);
        return "redirect:/professores";
    }
}








