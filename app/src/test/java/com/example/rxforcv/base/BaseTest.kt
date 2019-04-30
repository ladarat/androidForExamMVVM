package com.example.rxforcv.base

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class BaseTest {
    @get:Rule
    var rxImmediateSchedulerRule = RxImmediateSchedulerRule()

    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    var instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
}