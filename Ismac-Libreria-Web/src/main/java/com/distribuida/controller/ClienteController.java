package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.distribuida.dto.ClienteService;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET-SELECT - finAll()
    @GetMapping("/findAll")
    private String findAll(Model model) {
        List<Cliente> clientes = clienteService.finAll();
        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    // GET-SELECT - findOne
    @GetMapping("/findOne")
    private String findOne(@RequestParam("idCliente") @Nullable Integer idCliente,
                           @RequestParam("opcion") @Nullable Integer opcion, Model model) {
        if (idCliente != null) {
            Cliente cliente = clienteService.findOne(idCliente);
            model.addAttribute("cliente", cliente);
        }
        if (opcion == 1) {
            return "clientes-add";
        } else {
            return "clientes-del";
        }
    }

    // POST-SELECT - add
    @PostMapping("/add")
    private String add(@RequestParam("idCliente") @Nullable Integer idCliente,
                       @RequestParam("cedula") @Nullable String cedula,
                       @RequestParam("nombre") @Nullable String nombre,
                       @RequestParam("apellido") @Nullable String apellido,
                       @RequestParam("direccion") @Nullable String direccion,
                       @RequestParam("telefono") @Nullable String telefono,
                       @RequestParam("correo") @Nullable String correo,
                       Model model) {

        if (idCliente == null) {
            clienteService.add(0, cedula, nombre, apellido, direccion, telefono, correo);
        } else {
            clienteService.up(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
        }

        return "redirect:/clientes/findAll";
    }


    // DELETE - DELETE - DEL
    @GetMapping("/del")
    private String del(@RequestParam("idCliente") @Nullable Integer idCliente) {
        clienteService.del(idCliente);
        return "redirect:/clientes/findAll";
    }
}
