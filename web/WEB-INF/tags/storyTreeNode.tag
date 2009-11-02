<%@ include file="../jsp/inc/_taglibs.jsp"%>
<%@ tag
  description="Constructs story tree starting from the given story node"%>

<%@ attribute type="fi.hut.soberit.agilefant.model.Story"
  name="node"%>
  <li storyid="${node.id}" storystate="${node.state}">
    <div class="inlineTaskState taskState${node.state}" title="<aef:text name="story.state.${node.state}" />">${fn:substring(node.state, 0, 1)}</div>
    <span title="<c:out value="${node.name}" />"><c:out value="${node.name}" /></span>
    <c:if test="${node.children != null}">
    <ul>
      <c:forEach items="${node.children}" var="childStory">
       <aef:storyTreeNode node="${childStory}"/>
      </c:forEach>
    </ul>
    </c:if>
  </li>