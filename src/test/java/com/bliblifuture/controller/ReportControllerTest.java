package com.bliblifuture.controller;

import com.bliblifuture.OsloConstanta;
import com.bliblifuture.model.Report;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.request.ReportRequest;
import com.bliblifuture.service.ReportService;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;
import static org.hamcrest.Matchers.containsString;

// Controller baru bisa dites jika aplikasi dijalankan,
// fungsi @RunWith berfungsi untuk menjalankan aplikasi

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class ReportControllerTest {

//    Membuat bean yang merupakan mock dari ReportService
    @MockBean
    private ReportService reportService;

//    Untuk memberi tahu port yang digunakan
    @LocalServerPort
    private int serverPort;

//    Untuk melakukan mapping data dari request ke jason
    ObjectMapper mapper = new ObjectMapper();

//   Deklarasi variabel yang akan digunakan
    Report report = new Report();
    LocalDate date = LocalDate.parse("2017-01-01", DateTimeFormat.forPattern("yyyy-MM-dd"));
    List<StockOpname> stockOpnameList = new ArrayList<>();


//    Mengisi variabel yang akan digunakan
    @Before
    public void setUp(){
        report.setDate(date);
        report.setStockOpnames(stockOpnameList);
        report.setCountedQty(10);
        report.setCountedSKU(100);
        report.setDeficitQty(10);
        report.setDeficitSKU(5);
        report.setSurplusQty(10);
        report.setSurplusSKU(5);
        report.setTotalUnknownQty(10);
        report.setTotalUnknownSKU(10);
    }
        @Test
        public void findOrCreateReport(){

            // Mockup service
            when(reportService.findOrCreateReportByDate("20170101")).thenReturn(report);

            // Deklarasi kondisi yang diinginkan
            given()
                .contentType("application/json")        // Request yang diinputkan oleh user via json
                .when()                                 // Kondisi saat user melakukan Get/Post
                .port(serverPort)
                .get("/api/reports?date=20170101")
                .then()                                 // Kondisi setelah user menerima balasan
                .body(containsString("2017-01-01"))
                .body(containsString("true"))
                .body(containsString("10"))
                .body(containsString("100"))
                .body(containsString("5"))
                .statusCode(200);

            // Dicocokan dengan fungsi equals yang kita buat di model Report
            verify(reportService).findOrCreateReportByDate("20170101");
        }
}
