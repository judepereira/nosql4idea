/*
 * Copyright (c) 2015 David Boissier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codinjutsu.tools.nosql.mongo;

import com.intellij.openapi.project.Project;
import org.codinjutsu.tools.nosql.commons.DatabaseUI;
import org.codinjutsu.tools.nosql.commons.view.AuthenticationView;
import org.codinjutsu.tools.nosql.commons.view.NoSqlResultView;
import org.codinjutsu.tools.nosql.commons.view.editor.NoSqlDatabaseObjectFile;
import org.codinjutsu.tools.nosql.mongo.logic.SingleMongoClient;
import org.codinjutsu.tools.nosql.mongo.view.MongoAuthenticationPanel;
import org.codinjutsu.tools.nosql.mongo.view.MongoPanel;
import org.codinjutsu.tools.nosql.mongo.view.editor.MongoObjectFile;

public class MongoUI implements DatabaseUI {


    @Override
    public AuthenticationView createAythenticationView() {
        return new MongoAuthenticationPanel();
    }

    @Override
    public NoSqlResultView createResultPanel(Project project, NoSqlDatabaseObjectFile objectFile) {
        MongoObjectFile mongoObjectFile = (MongoObjectFile) objectFile;
        return new MongoPanel(project,
                SingleMongoClient.getInstance(project),
                mongoObjectFile.getConfiguration(),
                mongoObjectFile.getCollection());
    }
}
