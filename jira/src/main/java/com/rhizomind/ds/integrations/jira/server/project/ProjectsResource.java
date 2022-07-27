package com.rhizomind.ds.integrations.jira.server.project;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProjectsResource {



    @GET
    List<ProjectRepresentation> findAll(@QueryParam("expand") Expand expand);

    @Path("{id}")
    ProjectResource findOne(@PathParam("id") String id);


    enum ProjectExpandOptions {

        description,lead,issueTypes,url,projectKeys,permissions,insight

    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    class Expand {

        private List<ProjectExpandOptions> expandOptions;

        public static Expand all(){
            return new Expand(Arrays.asList(ProjectExpandOptions.values()));
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (ProjectExpandOptions o : expandOptions) {
                if (stringBuilder.length()>0) {
                    stringBuilder.append(",").append(o.name());
                } else {
                    stringBuilder.append(o.name());
                }
            }
            return stringBuilder.toString();
        }
    }

}
