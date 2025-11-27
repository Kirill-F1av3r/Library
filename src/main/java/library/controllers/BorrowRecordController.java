package library.controllers;

import jakarta.validation.Valid;
import library.models.BorrowRecord;
import library.models.BorrowRecordDTO;
import library.services.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/borrow_records")
public class BorrowRecordController extends AbstractController<BorrowRecord> {
    private final BorrowRecordService borrowRecordService;

    private static final String NAME_RECOURSE = "borrow_record";
    private static final String RECOURSES = "borrow_records";

    @Autowired
    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        super(borrowRecordService, NAME_RECOURSE, RECOURSES);
        this.borrowRecordService = borrowRecordService;
    }

    @Override
    protected BorrowRecord createRecourse() {
        return new BorrowRecord();
    }

    @Override
    public String create(@ModelAttribute("borrow_record") @Valid BorrowRecord borrowRecord,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "borrow_records/new";
        }

        borrowRecordService.create(borrowRecord);
        return "redirect:/borrow_records";
    }

    @Override
    public String update(@PathVariable("id") int id, @ModelAttribute("borrow_record") @Valid BorrowRecord borrowRecord,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "borrow_records/edit";
        }

        borrowRecordService.update(id, borrowRecord);
        return "redirect:/borrow_records";
    }

    @Override
    public String index(Model model) {
        model.addAttribute(RECOURSES, borrowRecordService.indexDTO());
        return RECOURSES + "/index";
    }

    @Override
    public String show(@PathVariable("id") int id, Model model) {
        Optional<BorrowRecordDTO> t = borrowRecordService.showDTO(id);
        if (t.isPresent()) {
            model.addAttribute(NAME_RECOURSE, t.get());
            return RECOURSES + "/show";
        }
        return RECOURSES + "/notValue";
    }
}
