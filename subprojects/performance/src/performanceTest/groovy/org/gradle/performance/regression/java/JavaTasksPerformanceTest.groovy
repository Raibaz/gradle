/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.performance.regression.java

import org.gradle.performance.AbstractCrossVersionPerformanceTest

class JavaTasksPerformanceTest extends AbstractCrossVersionPerformanceTest {

    def "tasks"() {
        given:
        runner.gradleOpts = runner.projectMemoryOptions
        runner.tasksToRun = ['tasks']
        runner.targetVersions = ["6.8-20200917220028+0000"]

        when:
        def result = runner.run()

        then:
        result.assertCurrentVersionHasNotRegressed()
    }

    def "tasks --all"() {
        given:
        runner.gradleOpts = runner.projectMemoryOptions
        runner.tasksToRun = ['tasks', '--all']
        runner.targetVersions = ["6.8-20200917220028+0000"]

        when:
        def result = runner.run()

        then:
        result.assertCurrentVersionHasNotRegressed()
    }
}
