# Example
It helps you create Microsoft Excel documents.
The first, you need create Java class with specific annotation:

```Java
@XlsTable
@XlsTitle("Beautiful Cars")
public class CarsTable {

    @XlsTitle(
            value = "Mark",
            font = @XlsFont(size = 20, family = "Serif"),
            border = @XlsBorder(size = 2))
    @XlsFont(
            size = 15,
            family = "Serif"
    )
    @XlsBorder(size = 1)
    @XlsAlign(ExcelAlign.CENTER)
    private String mark;

    @XlsTitle(
            value = "Price",
            font = @XlsFont(size = 20, family = "Serif")
    )
    @XlsFont(
            size = 15,
            family = "Serif"
    )
    private BigDecimal price;

    @XlsTitle(
            value = "Status",
            font = @XlsFont(size = 20, family = "Serif")
    )
    @XlsFont(
            size = 15,
            family = "Arial"
    )
    private String status;

    public CarsTable(String mark, BigDecimal price, String status) {
        this.mark = mark;
        this.price = price;
        this.status = status;
    }
    
    // getters and setters
}
```

And for save your Excel to file you need make the following:

```Java
List<CarsTable> cars = new ArrayList<>();
cars.add(new CarsTable("BMW", new BigDecimal(15_000), "SOLD"));
cars.add(new CarsTable("Ferrari", new BigDecimal(35_000), "SOLD"));
cars.add(new CarsTable("Ford", new BigDecimal(9_000), "SOLD OUT"));

ExcelContext workbook = ExcelTabler.getWorkbook();
workbook.addTable(cars);
workbook.writeToFile("/Users/ermolaev/Documents/tables.xls");
```
