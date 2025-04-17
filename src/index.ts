import { registerPlugin } from '@capacitor/core';

import type { PingPluginPlugin } from './definitions';

const PingPlugin = registerPlugin<PingPluginPlugin>('PingPlugin', {
  web: () => import('./web').then((m) => new m.PingPluginWeb()),
});

export * from './definitions';
export { PingPlugin };
