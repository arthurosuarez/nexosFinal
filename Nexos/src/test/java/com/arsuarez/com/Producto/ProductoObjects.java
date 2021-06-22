package com.arsuarez.com.Producto;



public class ProductoObjects {

    public static final String  PRODUCTO_CREATE_OK = "{\n" +
            "\t\"nombre\" : \"Parachoques\",\n" +
            "\t\"cantidad\" : 10,\n" +

            "\t\"fechaIngreso\" : 2021-01-01,\n" +
            "\t\"creadorCodigo\" : 1\n" +

            "}";


	
    public static final String  PRODUCTO_CREATE_ERROR = "{\n" +
            "\t\"nombre\" : \"Parachoques\",\n" +
            "\t\"cantidad\" : 10,\n" +

            "\t\"fechaIngreso\" : 2021-01-01,\n" +
            "\t\"creadorCodigo\" : 1\n" +

            "}";

    public static final String  PRODUCTO_UPDATE_OK = "{\n" +

    	"\t\"codigo\" : \"1\",\n" +	
    	"\t\"nombre\" : \"Parachoques\",\n" +
	    "\t\"cantidad\" : 10,\n" +
	
	    "\t\"fechaIngreso\" : 2021-01-01,\n" +
	    "\t\"creadorCodigo\" : 1\n" +
	
	    "}";

    public static final String  PRODUCTO_UPDATE_ERROR = "{\n" +

    	"\t\"codigo\" : \"8989898\",\n" +	
    	"\t\"nombre\" : \"Parachoques\",\n" +
	    "\t\"cantidad\" : 10,\n" +
	
	    "\t\"fechaIngreso\" : 2021-01-01,\n" +
	    "\t\"creadorCodigo\" : 1\n" +
	
	    "}";

    public static final String  PRODUCTO_DELETE_OK = "1";
    public static final String  PRODUCTO_DELETE_ERROR = "1";
}
