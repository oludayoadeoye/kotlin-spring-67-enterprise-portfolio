package com.portfolio.customoperatingsystem.domain.service

import com.portfolio.customoperatingsystem.domain.model.Process
import org.springframework.stereotype.Service

@Service
class KernelService {
    private val processes = mutableListOf(Process(1, "Init"), Process(2, "Shell"))

    fun getProcesses(): List<Process> = processes
    fun spawn(name: String): Process {
        val p = Process(processes.size + 1, name)
        processes.add(p)
        return p
    }
}
