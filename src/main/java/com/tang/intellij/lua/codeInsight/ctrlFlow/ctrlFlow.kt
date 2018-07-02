/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.lua.codeInsight.ctrlFlow

import com.tang.intellij.lua.psi.LuaBlock
import com.tang.intellij.lua.psi.LuaLocalFuncDef
import com.tang.intellij.lua.psi.LuaNameDef

interface CtrlFlowInstructionsBuilder {
    fun <T : VMInstruction> addInstruction(instruction: T): T

    fun enterScope(block: LuaBlock)
    fun exitScope(block: LuaBlock): VMPseudoCode

    fun declareParameter(param: LuaNameDef)
    fun declareLocalVar(local: LuaNameDef)
    fun declareLocalFun(local: LuaLocalFuncDef)

    fun returnValue()

    fun getPseudoCode(): VMPseudoCode
}