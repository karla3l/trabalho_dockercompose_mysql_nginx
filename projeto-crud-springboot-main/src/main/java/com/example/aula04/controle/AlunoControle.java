package com.example.aula04.controle;
import javax.validation.constraints.Null;
import com.example.aula04.entidade.Aluno;
import com.example.aula04.servico.AlunoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AlunoControle {

    @Autowired
    private AlunoServico alunoServico;

    
    @GetMapping("/alunos")
    public ModelAndView getAlunos(){
        
        ModelAndView mv = new ModelAndView("alunosTemplate");
    
        mv.addObject("aluno",  new Aluno());
        mv.addObject("alunos", alunoServico.getAlunos());
        
        
        return mv;
    }

    @GetMapping("/removerAluno")
    public String removerAluno(@RequestParam Integer matricula){
        
        Aluno aluno = alunoServico.getAlunoById(matricula);
        alunoServico.remover(aluno);

        return "redirect:/alunos";
    }

    @GetMapping("/editarAluno")
    public ModelAndView editarAluno(@RequestParam Integer matricula){
        
        ModelAndView mv = new ModelAndView("alunoEdit");
    
        Aluno aluno = alunoServico.getAlunoById(matricula); 
        mv.addObject("aluno",  aluno);
       

        return mv;
   
    }

    @PostMapping("/salvarAluno")
    public String salvar(@ModelAttribute Aluno aluno){
        alunoServico.salvar(aluno);
        return "redirect:/alunos";
    }
}








