package ai.preferred.regression.pe;

import ai.preferred.regression.io.CSVInputData;
import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class AddX3 extends ProcessingElement {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddX3.class);

  @Option(name = "-c", aliases = {"--column"}, usage = "the index of the column", required = true)
  private int column;

  @Override
  protected void process(CSVInputData data, CSVPrinter printer) throws IOException {
    if (data.hasHeader()) {
      ArrayList<String> header = data.getHeader();
      // TODO: transform this header here!
      // FOR EXAMPLE:
      // header.add("NEW_COLUMN");
      printer.printRecord(header);
    }

    for (final ArrayList<String> record : data) {
      // TODO: transform each record here!
      // FOR EXAMPLE:
      // record.add("VALUE");
      printer.printRecord(record);
    }
  }

  public static void main(String[] args) {
    parseArgsAndRun(AddX3.class, args);
  }

}
