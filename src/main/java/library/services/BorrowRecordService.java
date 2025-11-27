package library.services;

import library.models.BorrowRecord;
import library.models.BorrowRecordDTO;
import library.repositories.BorrowRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService extends AbstractService<BorrowRecord> {

    private final BorrowRecordDAO borrowRecordDAO;

    @Autowired
    public BorrowRecordService(BorrowRecordDAO borrowRecordDAO) {
        super(borrowRecordDAO);
        this.borrowRecordDAO = borrowRecordDAO;
    }

    public List<BorrowRecordDTO> indexDTO() {
        return borrowRecordDAO.getListDTO();
    }

    public Optional<BorrowRecordDTO> showDTO(int id) {
        return Optional.ofNullable(borrowRecordDAO.getDTO(id));
    }

}
