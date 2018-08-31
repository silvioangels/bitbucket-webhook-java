/*
 * Activity
 * Copyright (C) 2015 Nishimura Software Studio
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.vx68k.bitbucket.webhook;

import java.util.logging.Logger;
import javax.json.JsonObject;
import org.vx68k.bitbucket.api.client.Repository;
import org.vx68k.bitbucket.api.client.User;

/**
 * Activity on a Bitbucket repository.
 * @author Kaz Nishimura
 * @since 1.0
 */
public abstract class Activity {

    private static final String LOG_MESSAGES = "resources/LogMessages";

    private User actor;

    private Repository repository;

    protected Activity() {
    }

    protected Activity(JsonObject jsonObject) {
        actor = new User(jsonObject.getJsonObject(WebhookJsonKeys.ACTOR));
        repository = new Repository(
                jsonObject.getJsonObject(WebhookJsonKeys.REPOSITORY));
    }

    /**
     * Returns the actor of this object.
     * @return actor
     */
    public User getActor() {
        return actor;
    }

    /**
     * Returns the repository of this object.
     * @return repository
     */
    public Repository getRepository() {
        return repository;
    }

    /**
     * Sets the actor of this object.
     * @param actor actor
     */
    public void setActor(User actor) {
        this.actor = actor;
    }

    /**
     * Sets the repository of this object.
     * @param repository repository
     */
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    /**
     * Returns the logger for this package.
     * @return logger
     */
    protected static Logger getLogger() {
        return Logger.getLogger(
                Activity.class.getPackage().getName(), LOG_MESSAGES);
    }
}
