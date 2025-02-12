/* SQLGenerator.java */
/* Generated By:JavaCC: Do not edit this line. SQLGenerator.java */
package compilation_project;

import java.io.*;
import java.util.*;

public class SQLGenerator implements SQLGeneratorConstants {
    private List<TableDefinition> tables = new ArrayList<>();

    public static void main(String args[]) throws ParseException {
        SQLGenerator parser = new SQLGenerator(System.in);
        parser.Parse();
    }

    public String getGeneratedSQL() {
        StringBuilder sql = new StringBuilder();
        for (TableDefinition table : tables) {
            sql.append(table.toSQL()).append("\n\n");
        }
        return sql.toString();
    }

    public List<TableDefinition> getTables() {
        return tables;
    }

  final public void Parse() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TABLE:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      TableDefinition();
    }
    jj_consume_token(0);
}

  final public void TableDefinition() throws ParseException {Token tableName;
    TableDefinition table;
    jj_consume_token(TABLE);
    tableName = jj_consume_token(IDENTIFIER);
    jj_consume_token(COLON);
table = new TableDefinition(tableName.image);
        tables.add(table);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DASH:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      ColumnDefinition(table);
    }
}

  final public void ColumnDefinition(TableDefinition table) throws ParseException {Token columnName;
    List<String> constraints = new ArrayList<>();
    String type = "";
    jj_consume_token(DASH);
    columnName = jj_consume_token(IDENTIFIER);
    jj_consume_token(LPAREN);
    type = Type();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      Constraint(constraints);
    }
    jj_consume_token(RPAREN);
table.addColumn(new ColumnDefinition(columnName.image, type, constraints));
}

  final public String Type() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INTEGER_TYPE:{
      t = jj_consume_token(INTEGER_TYPE);
{if ("" != null) return "INT";}
      break;
      }
    case TEXT_TYPE:{
      t = jj_consume_token(TEXT_TYPE);
{if ("" != null) return "VARCHAR(255)";}
      break;
      }
    case DATE_TYPE:{
      t = jj_consume_token(DATE_TYPE);
{if ("" != null) return "DATE";}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public void Constraint(List<String> constraints) throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PRIMARY_KEY:{
      jj_consume_token(PRIMARY_KEY);
constraints.add("PRIMARY KEY");
      break;
      }
    case AUTO:{
      jj_consume_token(AUTO);
constraints.add("AUTO_INCREMENT");
      break;
      }
    case REQUIRED:{
      jj_consume_token(REQUIRED);
constraints.add("NOT NULL");
      break;
      }
    case UNIQUE:{
      jj_consume_token(UNIQUE);
constraints.add("UNIQUE");
      break;
      }
    case DEFAULT_VALUE:{
      jj_consume_token(DEFAULT_VALUE);
constraints.add("DEFAULT CURRENT_TIMESTAMP");
      break;
      }
    case REFERENCE:{
      jj_consume_token(REFERENCE);
      jj_consume_token(COLON);
      t = jj_consume_token(IDENTIFIER);
constraints.add("REFERENCES " + t.image + "(id)");
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  /** Generated Token Manager. */
  public SQLGeneratorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[5];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x20,0x400,0x200,0x3800,0xfc000,};
	}

  /** Constructor with InputStream. */
  public SQLGenerator(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SQLGenerator(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new SQLGeneratorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public SQLGenerator(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new SQLGeneratorTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new SQLGeneratorTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public SQLGenerator(SQLGeneratorTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(SQLGeneratorTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 5; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[21];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 5; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 21; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
