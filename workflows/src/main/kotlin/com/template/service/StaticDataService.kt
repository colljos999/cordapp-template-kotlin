package com.template.service

import net.corda.core.CordaException
import net.corda.core.node.AppServiceHub
import net.corda.core.node.services.CordaService
import net.corda.core.serialization.SingletonSerializeAsToken

@CordaService
class StaticDataService(private val appServiceHub: AppServiceHub): SingletonSerializeAsToken() {

    private val data by lazy { javaClass.classLoader.getResource("static.data")?.readText() }

    fun getStaticData() = data ?: throw CordaException("Unable to load static data")
}