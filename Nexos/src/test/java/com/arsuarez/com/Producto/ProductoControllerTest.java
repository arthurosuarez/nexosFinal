package com.arsuarez.com.Producto;


import com.arsuarez.com.NexosApplication;
//import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
//import org.flywaydb.test.FlywayTestExecutionListener;
//import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.arsuarez.com.Producto.ProductoObjects.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = NexosApplication.class)
@AutoConfigureMockMvc
@TestPropertySource( locations = "/db/migration/")


//@FlywayTest(invokeCleanDB = false, locationsForMigrate = {""})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class ProductoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initTests() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void test1DebeCrearProducto() throws Exception {
        mockMvc.perform(post("/registrarProductoAcc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_CREATE_OK)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro guardado correctamente")))
                .andExpect(jsonPath("$.status.result", is(200)));
    }

    @Test
    public void test2DebeDarErrorCrearProducto() throws Exception {
        mockMvc.perform(post("/registrarProductoAcc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_CREATE_ERROR)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro ya existe.")))
                .andExpect(jsonPath("$.status.result", is(200)));
    }

    @Test
    public void test3DebeEditarProducto() throws Exception {
        mockMvc.perform(post("/editarProductoAcc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_UPDATE_OK)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro editado correctamente!!")))
                .andExpect(jsonPath("$.status.result", is(200)));
    }

    @Test
    public void test4DebeDarErrorEditarProducto() throws Exception {
        mockMvc.perform(post("/editarProductoAcc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_UPDATE_ERROR)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro no existe.")))
                .andExpect(jsonPath("$.status.result", is(200)));
    }

    
    
    
    @Test
    public void test5DebeEliminarProducto() throws Exception {
        mockMvc.perform(get( "/eliminarProductoAcc?codigo=".concat(PRODUCTO_DELETE_OK) )
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_UPDATE_ERROR)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro Eliminado correctamente")))
                .andExpect(jsonPath("$.status.result", is(200)));
        
    }
    
    @Test
    public void test6DebeDarErrorEliminarProducto() throws Exception {
        mockMvc.perform(get( "/eliminarProductoAcc?codigo=".concat(PRODUCTO_DELETE_ERROR) )
                .contentType(MediaType.APPLICATION_JSON)
                .content(PRODUCTO_UPDATE_ERROR)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status.mensaje", is("Registro no existe.")))
                .andExpect(jsonPath("$.status.result", is(200)));
    }
    

   

}