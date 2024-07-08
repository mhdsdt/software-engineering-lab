import { defineConfig } from 'vite'

const base = process.env.DEPLOY_ENV === 'staging' ? '/se-lab-1-staging/' : '/se-lab-1/'

export default defineConfig({
  base
})
