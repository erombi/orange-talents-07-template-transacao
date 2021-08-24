package br.com.zup.academy.transacoes.domain;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ExecutorTransaction {

    @Transactional
    public void inTransaction(Runnable runnable) {
        runnable.run();
    }
}
