package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas = new ArrayList<Conta>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta(this.generateId(), 100.00));
        contas.add(new Conta(this.generateId(), 400.00));
        contas.add(new Conta(this.generateId(), 2100.00));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return contas.get(Integer.parseInt(conta)).getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    public boolean novaConta(Double saldo) throws  RemoteException {
        return contas.add(new Conta(generateId(), saldo));
    }

    private String generateId() {
        return String.valueOf(this.contas.size() + 1);
    }

}
