/*
 * $Id$
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 */
package org.jdesktop.swingx;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JViewport;
import javax.swing.Scrollable;
import javax.swing.UIManager;

import org.jdesktop.swingx.plaf.JXTaskPaneContainerAddon;
import org.jdesktop.swingx.plaf.LookAndFeelAddons;
import org.jdesktop.swingx.plaf.TaskPaneContainerUI;

/**
 * <code>JXTaskPaneContainer</code> provides an elegant view
 * to display a list of tasks ordered by groups.
 * It can be added to a JScrollPane.
 *
 * @javabean.attribute
 *          name="isContainer"
 *          value="Boolean.TRUE"
 *          rtexpr="true"
 * 
 * @javabean.class
 *          name="JXTaskPaneContainer"
 *          shortDescription="A component that contains JTaskPaneGroups."
 *          stopClass="java.awt.Component"
 * 
 * @javabean.icons
 *          mono16="JXTaskPaneContainer16-mono.gif"
 *          color16="JXTaskPaneContainer16.gif"
 *          mono32="JXTaskPaneContainer32-mono.gif"
 *          color32="JXTaskPaneContainer32.gif"
 */
public class JXTaskPaneContainer extends JComponent implements Scrollable {

  public final static String uiClassID = "swingx/TaskPaneContainerUI";
  
  // ensure at least the default ui is registered
  static {
    LookAndFeelAddons.contribute(new JXTaskPaneContainerAddon());
  }

  /**
   * Creates a new empty taskpane.
   */
  public JXTaskPaneContainer() {
    updateUI();
  }

  /**
   * Notification from the <code>UIManager</code> that the L&F has changed.
   * Replaces the current UI object with the latest version from the <code>UIManager</code>.
   * 
   * @see javax.swing.JComponent#updateUI
   */
  public void updateUI() {
    setUI((TaskPaneContainerUI)LookAndFeelAddons.getUI(this, TaskPaneContainerUI.class, UIManager
      .getUI(this)));
  }

  /**
   * Sets the L&F object that renders this component.
   * 
   * @param ui the <code>TaskPaneContainerUI</code> L&F object
   * @see javax.swing.UIDefaults#getUI
   * 
   * @beaninfo bound: true hidden: true description: The UI object that
   * implements the taskpane's LookAndFeel.
   */
  public void setUI(TaskPaneContainerUI ui) {
    super.setUI(ui);
  }

  /**
   * Returns the name of the L&F class that renders this component.
   * 
   * @return the string {@link #uiClassID}
   * @see javax.swing.JComponent#getUIClassID
   * @see javax.swing.UIDefaults#getUI
   */
  public String getUIClassID() {
    return uiClassID;
  }

  /**
   * Adds a <code>JXTaskPane</code> to this JXTaskPaneContainer.
   * 
   * @param group
   */
  public void add(JXTaskPane group) {
    super.add(group);
  }

  /**
   * Removes a <code>JXTaskPane</code> from this JXTaskPaneContainer.
   * 
   * @param group
   */
  public void remove(JXTaskPane group) {
    super.remove(group);
  }

  /**
   * @see Scrollable#getPreferredScrollableViewportSize()
   */
  public Dimension getPreferredScrollableViewportSize() {
    return getPreferredSize();
  }

  /**
   * @see Scrollable#getScrollableBlockIncrement(java.awt.Rectangle, int, int)
   */
  public int getScrollableBlockIncrement(
    Rectangle visibleRect,
    int orientation,
    int direction) {
    return 10;
  }
  
  /**
   * @see Scrollable#getScrollableTracksViewportHeight()
   */
  public boolean getScrollableTracksViewportHeight() {
    if (getParent() instanceof JViewport) {
      return (((JViewport)getParent()).getHeight() > getPreferredSize().height);
    } else {
      return false;
    }
  }
  
  /**
   * @see Scrollable#getScrollableTracksViewportWidth()
   */
  public boolean getScrollableTracksViewportWidth() {
    return true;
  }
  
  /**
   * @see Scrollable#getScrollableUnitIncrement(java.awt.Rectangle, int, int)
   */
  public int getScrollableUnitIncrement(
    Rectangle visibleRect,
    int orientation,
    int direction) {
    return 10;
  }
  
}
