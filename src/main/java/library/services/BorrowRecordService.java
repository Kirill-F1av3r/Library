package library.services;

import library.models.BorrowRecord;
import library.repositories.BorrowRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowRecordService extends AbstractService<BorrowRecord> {

    @Autowired
    public BorrowRecordService(BorrowRecordDAO borrowRecordDAO) {
        super(borrowRecordDAO);
    }

}
