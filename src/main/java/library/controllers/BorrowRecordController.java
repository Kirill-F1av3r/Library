package library.controllers;

import jakarta.validation.Valid;
import library.models.BorrowRecord;
import library.services.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
