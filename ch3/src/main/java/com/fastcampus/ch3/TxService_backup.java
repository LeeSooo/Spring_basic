//package com.fastcampus.ch3;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class TxService_backup {
//    @Autowired A1Dao a1Dao;
//    @Autowired B1Dao b1Dao;
//
//    public void insertA1WithTx() throws Exception {
//        a1Dao.insert(1, 100); // 성공
//        insertB1WtihTx();
//        a1Dao.insert(1, 200); // 실패
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
//    public void insertB1WtihTx() throws Exception {
//        b1Dao.insert(1, 100); // 성공
//        b1Dao.insert(2, 200); // 성공
//    }
//
//    public void insertA1WithoutTx() throws Exception {
//        a1Dao.insert(1, 100);
//        a1Dao.insert(1, 200);
//    }
//
////    @Transactional  // RuntimeException, Error만 rollback
//    @Transactional(rollbackFor = Exception.class) // Exception을 rollback
//    public void insertA1WithTxFail() throws Exception {
//        a1Dao.insert(1, 100); // 성공
////        throw new RuntimeException();
////        throw new Exception();
//        a1Dao.insert(1, 200); // 실패
//    }
//
//    @Transactional
//    public void insertA1WithTxSuccess() throws Exception {
//        a1Dao.insert(1, 100);
//        a1Dao.insert(2, 200);
//    }
//
//
//}
