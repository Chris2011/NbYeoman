package org.chrisle.netbeans.plugins.nbyeoman.wizard.rungenerator;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 *
 * @author ChrisLE
 */
public class YeomanRunGeneratorWizardPanel implements WizardDescriptor.Panel {
    private WizardDescriptor wizardDescriptor;
    private YeomanRunGeneratorPanelVisual component;
    private final Set<ChangeListener> listeners = new HashSet<ChangeListener>(1); // or can use ChangeSupport in NB 6.0
    
    public YeomanRunGeneratorWizardPanel() {
    }

    @Override
    public Component getComponent() {
    if (component == null) {
            component = new YeomanRunGeneratorPanelVisual(this);
            component.setName(NbBundle.getMessage(YeomanRunGeneratorWizardPanel.class, "LBL_RunGeneratorStep"));
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        return new HelpCtx("org.chrisle.netbeans.plugins.nbyeoman.wizard.choosegenerator.YeomanLocationWizardPanel");
    }

    @Override
    public void readSettings(Object data) {
        
    }

    @Override
    public void storeSettings(Object data) {
        
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
        synchronized (listeners) {
            listeners.add(cl);
        }
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
        synchronized (listeners) {
            listeners.remove(cl);
        }
    }
}
