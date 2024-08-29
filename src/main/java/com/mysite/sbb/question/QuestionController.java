package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @GetMapping("/question/list")
    public String list(Model model) {
        Optional<Question> optionalQuestion = this.questionRepository.findById(2);
        Question question = optionalQuestion.get();
        List<Answer> answerList = this.answerRepository.findAllByQuestion(question);
        model.addAttribute("answerList", answerList);
        model.addAttribute("question", question);
        return "question_list";
    }
}
