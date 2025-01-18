package com.maria;

import service.RecordService;

public class Main {
    public static void main(String[] args) {

        RecordService recordService = new RecordService();

        recordService.save();
        recordService.updateRecord();
        recordService.deleteRecord();
        recordService.getAllRecords();
    }
}
